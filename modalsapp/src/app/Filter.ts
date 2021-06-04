import { SubFilter } from "./SubFilters";

export interface Filter {
    id?: number;
    title: string;
    subfilters: SubFilter[];
}