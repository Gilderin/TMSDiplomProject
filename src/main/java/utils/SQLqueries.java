package utils;

public class SQLqueries {

    public String ProjectInformationSelect(Integer id) {
        return "Select pr.name, pt.type, pr.announcement, pr.show_announcement, pr.\"projectType\" from public.\"Projects\" as pr" +
                " join public.\"ProjectsType\" pt on pr.\"projectType\"=pt.\"id\"" +
                " where pr.\"id\"='" + id + "'";
    }

    public String LoginInformationSelect(Integer id) {
        return "Select * from public.\"Users\"" +
                " where \"Users\".\"id\"='" + id + "'";
    }

    public String TestCasesInformationSelect(Integer id) {
        return "Select title, template, priority, estimate, type from public.\"TestCases\"" +
                " where id = '" + id + "'";
    }
}
