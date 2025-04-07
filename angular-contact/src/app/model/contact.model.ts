export class Contact {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    phone: string;
    address?: string;
    company?: string;
    jobTitle?: string;
    birthday?: string;
    categoryId?: number; 
    userId?: number; 
    constructor(id: number,
        firstName: string,
        lastName: string,
        email: string,
        phone: string,
        address: string,
        company: string,
        jobTitle: string,
        birthday: string,
        categoryId: number, 
        userId: number){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.company = company;
        this.jobTitle = jobTitle;
        this.birthday = birthday;
        this.categoryId = categoryId;
        this.userId = userId;
    }
}
