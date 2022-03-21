import {ITitle} from "../ITitle";
import {IHref} from "../IHref";

export interface IPagedTitles
{
  entityModels: ITitle[],
  _links: Map<string, IHref>
}
