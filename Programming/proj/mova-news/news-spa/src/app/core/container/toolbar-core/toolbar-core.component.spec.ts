import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToolbarCoreComponent } from './toolbar-core.component';

describe('ToolbarCoreComponent', () => {
  let component: ToolbarCoreComponent;
  let fixture: ComponentFixture<ToolbarCoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ToolbarCoreComponent ]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ToolbarCoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
