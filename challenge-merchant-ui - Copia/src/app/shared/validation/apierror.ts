import { SubError } from './suberror';

export class Apierror {
    status: string;
    timestamp: string;
    message: string;
    debugMessage: any;
    subErrors: SubError[];
}
