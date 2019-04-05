import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SendqueryComponent } from './sendquery.component';

describe('SendqueryComponent', () => {
  let component: SendqueryComponent;
  let fixture: ComponentFixture<SendqueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SendqueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SendqueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
