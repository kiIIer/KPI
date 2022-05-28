import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorCoreComponent } from './editor-core.component';

describe('EditorCoreComponent', () => {
  let component: EditorCoreComponent;
  let fixture: ComponentFixture<EditorCoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditorCoreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorCoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
