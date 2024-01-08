import { User } from "../models/User";
import { UserRole } from "../models/UserRole";
import { UserResponse } from "./user-response";

export class UserResponseMapper {
map(userResponse: UserResponse): User{
    return new User({
        ...userResponse,
        role:userResponse.role as UserRole
    })
}
}