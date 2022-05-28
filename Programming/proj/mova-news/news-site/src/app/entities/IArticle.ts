import {ILinks} from "./response/ILinks";
import {ISelfLink} from "./response/ISelfLink";

export interface IArticle
{
  id: string,
  title: string,
  article: string,
  dateCreated: bigint,
  _links: ISelfLink
}
