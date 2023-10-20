import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingMovieComponent } from './book-movie.component';

describe('BookMovieComponent', () => {
  let component: BookingMovieComponent;
  let fixture: ComponentFixture<BookingMovieComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BookingMovieComponent]
    });
    fixture = TestBed.createComponent(BookingMovieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
