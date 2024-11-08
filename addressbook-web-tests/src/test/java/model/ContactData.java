package model;

public record ContactData(String id, String firstName, String middleName, String lastName, String address, String email) {

    public ContactData() {
        this("", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.middleName, this.lastName, this.address, this.email);
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName, this.middleName, this.lastName, this.address, this.email);
    }

    public ContactData withFullName(String firstName, String middleName, String lastName) {
        return new ContactData(this.id, firstName, middleName, lastName, this.address, this.email);
    }

    public ContactData withAllData(String firstName, String middleName, String lastName, String address, String email) {
        return new ContactData(this.id, firstName, middleName, lastName, address, email);
    }
}

