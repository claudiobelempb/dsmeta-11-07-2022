import { TypeContent } from './TypeContent';
import { TypePageable } from './TypePageable';
import { TypeSort } from './TypeSort';

export type Sale = {
  content: TypeContent[];
  pageable?: TypePageable;
  last?: boolean;
  totalPages?: number;
  totalElements?: number;
  size?: number;
  number?: number;
  sort?: TypeSort;
  first?: boolean;
  numberOfElements?: number;
  empty?: boolean;
};
