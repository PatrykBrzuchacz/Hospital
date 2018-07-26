import { Examination } from './examination';
import { Question } from './question';
export class Result {
    id: Number;
    value: string;
    question: Question;
    examination: Examination;

    constructor(id: Number, value: string, question: Question, examination: Examination) {
        this.id = id;
        this.value = value;
        this.question = question;
        this.examination = examination;
    }
}
