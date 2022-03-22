import {ILinks} from "./ILinks";
import {ITitle} from "./ITitle";

export interface IPagedTitles
{
  entityModels: ITitle[],
  _links: ILinks
}
