export class Model {
  constructor(id: number, x: number, y: number, z: number, location: string, dateAndTime: string) {
    this.id = id;
    this.x = x;
    this.y = y;
    this.z = z;
    this.location = location;
    this.dateAndTime = dateAndTime;
  }
  id = 0;
  x = 0;
  y = 0;
  z = 0;
  location = '';
  dateAndTime = '';
}

