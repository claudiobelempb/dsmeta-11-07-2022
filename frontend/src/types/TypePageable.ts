import { TypeSort } from './TypeSort';

export type TypePageable = {
  sort: TypeSort;
  offset: number;
  pageNumber: number;
  pageSize: number;
  paged: boolean;
  unpaged: boolean;
};
