package utils;

public class SQLqueries {

    private String ProjectInformation = "";
    private String LoginInformation = "";

    public String ProjectInformationSelect(Integer id) {
        ProjectInformation ="Select * from public.\"Projects\" as pr" +
                " join public.\"ProjectsType\" pt on pr.\"projectType\"=pt.\"id\"" +
                " where pr.\"id\"='"+id+"'";
        return ProjectInformation;
    }

    public String LoginInformationSelect(Integer id) {
        LoginInformation = "Select * from public.\"Users\"" +
                " where \"Users\".\"id\"='"+id+"'";
        return LoginInformation;
    }

}
