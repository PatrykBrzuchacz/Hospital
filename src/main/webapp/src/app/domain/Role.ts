import { User } from "src/app/domain/user";

export class Role {
    id: Number;
    role_name: String;
    users:User[];
}