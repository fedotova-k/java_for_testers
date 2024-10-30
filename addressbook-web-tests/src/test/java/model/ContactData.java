package model;

public record ContactData(String firstName, String middleName, String lastName, String address, String email) {

    public ContactData() {
        this("", "", "", "","");
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(firstName, this.middleName, this.lastName, this.address, this.email);
    }

    public ContactData withFullName(String firstName, String middleName, String lastName) {
        return new ContactData(firstName, middleName, lastName, this.address, this.email);
    }

    public ContactData withAllData(String firstName, String middleName, String lastName, String address, String email) {
        return new ContactData(firstName, middleName, lastName, address, email);
    }
}

