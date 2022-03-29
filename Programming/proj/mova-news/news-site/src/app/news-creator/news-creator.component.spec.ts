import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewsCreatorComponent } from './news-creator.component';

describe('NewsCreatorComponent', () => {
  let component: NewsCreatorComponent;
  let fixture: ComponentFixture<NewsCreatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewsCreatorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewsCreatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
