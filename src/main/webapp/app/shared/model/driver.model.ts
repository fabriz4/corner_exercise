import dayjs from 'dayjs';
import { ICar } from 'app/shared/model/car.model';

export interface IDriver {
  id?: number;
  name?: string;
  surname?: string;
  driveLicenseId?: number;
  expirationDate?: string;
  releaseDate?: string;
  car?: ICar | null;
}

export const defaultValue: Readonly<IDriver> = {};
