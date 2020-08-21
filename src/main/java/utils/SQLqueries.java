package utils;

public class SQLqueries {

    private String ProjectInformation = "";
    private String LoginInformation = "";
    private String TestCasesInformation = "";

    public String ProjectInformationSelect(Integer id) {
        ProjectInformation ="Select * from public.\"Projects\" as pr\n" +
                "Join public.\"ProjectsType\" pt on pr.\"projectType\"=pt.\"id\"" +
                " where pr.\"id\"='"+id+"'";
        return ProjectInformation;
    }

    public String LoginInformationSelect(Integer id) {
        LoginInformation = "Select * from public.\"Users\"\n" +
                "where \"Users\".\"id\"='"+id+"'";
        return LoginInformation;
    }

    public String TestCasesInformationSelect(Integer id) {
        TestCasesInformation = "Select * from public.\"TestCases\"\n" +
                "where \"TestCases\".\"id\"='"+id+"'";
        return TestCasesInformation;
    }

}
