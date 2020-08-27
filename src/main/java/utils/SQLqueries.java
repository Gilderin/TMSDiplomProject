package utils;

public class SQLqueries {

    private String ProjectInformation = "";
    private String LoginInformation = "";
    private String TestCasesInformation = "";

    public String ProjectInformationSelect(Integer id) {
        ProjectInformation ="Select pr.name, pt.type, pr.announcement, pr.show_announcement, pr.\"projectType\" from public.\"Projects\" as pr" +
                " join public.\"ProjectsType\" pt on pr.\"projectType\"=pt.\"id\"" +
                " where pr.\"id\"='"+id+"'";
        return ProjectInformation;
    }

    public String LoginInformationSelect(Integer id) {
        LoginInformation = "Select * from public.\"Users\"" +
                " where \"Users\".\"id\"='"+id+"'";
        return LoginInformation;
    }

    public String TestCasesInformationSelect(Integer id) {
        TestCasesInformation = "Select * from public.\"TestCases\"\n" +
                "where \"TestCases\".\"id\"='"+id+"'";
        return TestCasesInformation;
    }

}
