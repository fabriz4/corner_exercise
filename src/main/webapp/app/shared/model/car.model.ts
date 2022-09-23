export interface ICar {
  id?: number;
  manufacturer?: string;
  model?: string;
  licensePlate?: string;
  seatCount?: number | null;
  convertible?: boolean | null;
  rating?: number | null;
  engineType?: string | null;
  avaiable?: boolean | null;
}

export const defaultValue: Readonly<ICar> = {
  convertible: false,
  avaiable: false,
};
