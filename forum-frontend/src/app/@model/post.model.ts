export class Post {
  constructor(
    public title: string,
    public content: string,
    public comments?: Comment[],
    public id?: number,
  ) {}
}
