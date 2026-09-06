public class W5Assignment2 {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        return AccessChecker.classifyAccess(fieldModifier, accessorContext);
    }

    public static String describeContext(String accessorContext) {
        return AccessChecker.describeContext(accessorContext);
    }

    public static class AccessChecker {
        public static String classifyAccess(String fieldModifier, String accessorContext) {
            if (fieldModifier == null || accessorContext == null)
                return "DENIED";
            if (fieldModifier.equals("private"))
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            if (fieldModifier.equals("default"))
                return accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")
                        ? "ALLOWED" : "DENIED";
            if (fieldModifier.equals("protected"))
                return accessorContext.equals("SAME_CLASS")
                        || accessorContext.equals("SAME_PACKAGE")
                        || accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")
                        ? "ALLOWED" : "DENIED";
            if (fieldModifier.equals("public"))
                return "ALLOWED";
            return "DENIED";
        }

        public static String describeContext(String accessorContext) {
            if (accessorContext == null || accessorContext.length() == 0)
                return "";

            String[] words = accessorContext.toLowerCase().split("_");
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                if (i > 0)
                    result.append(" ");
                result.append(Character.toUpperCase(words[i].charAt(0)))
                        .append(words[i].substring(1));
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("protected",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(classifyAccess("protected",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
        System.out.println(describeContext("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
    }
}
