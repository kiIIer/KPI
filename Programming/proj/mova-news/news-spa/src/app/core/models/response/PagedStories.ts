import {StoryEntity} from "../story.entity";

export interface PagedStories
{
  entityModels: StoryEntity[],
  _links: {
    nextPage: {
      href: string | undefined,
    }
  }
}
