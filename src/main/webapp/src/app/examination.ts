import { Question } from './question';
import { ExaminationTypes } from "./examination-types.enum";

export class Examination {
    id: Number;
    name: String;
    type: ExaminationTypes;
    questions: Question[] = [];

}
