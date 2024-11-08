package model;

public record ContactData(String id, String firstName, String middleName, String lastName) {

    public ContactData() {
        this("", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.middleName, this.lastName);
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName, this.middleName, this.lastName);
    }

    public ContactData withMiddleName(String firstName) {
        return new ContactData(this.id, this.firstName, middleName, this.lastName);
    }

    public ContactData withLastName(String firstName) {
        return new ContactData(this.id, this.firstName, this.middleName, lastName);
    }

    public ContactData withFirstAndLastName(String firstName, String lastName) {
        return new ContactData(this.id, firstName, this.middleName, lastName);
    }

}

