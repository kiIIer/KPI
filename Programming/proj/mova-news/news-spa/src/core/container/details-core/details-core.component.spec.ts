import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsCoreComponent } from './details-core.component';

describe('DetailsCoreComponent', () => {
  let component: DetailsCoreComponent;
  let fixture: ComponentFixture<DetailsCoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsCoreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsCoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
