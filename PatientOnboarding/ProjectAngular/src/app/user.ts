import { Role } from './role';
import { Hospital } from './hospital/hospital';

export class User {
    id: number;
    firstName: string;
    lastName: string;
    username: string;
    password: string;
    address: string;
    email: string;
    middleInit: string;
    state: string;
    zip: number;
    number: number;
    role: Role;
    hospital: Hospital;
}
