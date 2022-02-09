export class User{
    public mailId: string;
    public password: string;
    constructor(mailId:string, defaultPassword: string){
        this.mailId=mailId;
        this.password=defaultPassword;
    }
}