import { TestBed } from '@angular/core/testing';

import { LoggedAdminGuard } from './logged-admin.guard';

describe('LoggedInGuard', () => {
  let guard: LoggedAdminGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(LoggedAdminGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
