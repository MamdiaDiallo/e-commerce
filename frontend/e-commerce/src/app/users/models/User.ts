import { UserRole } from './UserRole';

type UserProps = {
  id?: string;
  lastname: string;
  firstname: string;
  role: UserRole;
  email: string;
};

export class User {
  id?: string;
  lastname: string;
  firstname: string;
  role: UserRole;
  email: string;
  
  constructor(props: UserProps) {
    this.id = props.id;
    this.lastname = props.lastname;
    this.firstname = props.lastname;
    this.email = props.email;
    this.role = props.role;
  }
}
