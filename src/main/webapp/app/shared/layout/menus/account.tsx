import React from 'react';
import MenuItem from 'app/shared/layout/menus/menu-item';

import { NavDropdown } from './menu-components';

const accountMenuItemsAuthenticated = () => (
  <>
    <MenuItem icon="wrench" to="/account/settings" data-cy="settings">
      설정
    </MenuItem>
    <MenuItem icon="lock" to="/account/password" data-cy="passwordItem">
      비밀번호
    </MenuItem>
    <MenuItem icon="sign-out-alt" to="/logout" data-cy="logout">
      로그아웃
    </MenuItem>
  </>
);

const accountMenuItems = () => (
  <>
    <MenuItem id="login-item" icon="sign-in-alt" to="/login" data-cy="login">
      인증
    </MenuItem>
    <MenuItem icon="user-plus" to="/account/register" data-cy="register">
      등록
    </MenuItem>
  </>
);

export const AccountMenu = ({ isAuthenticated = false }) => (
  <NavDropdown icon="user" name="계정" id="account-menu" data-cy="accountMenu">
    {isAuthenticated ? accountMenuItemsAuthenticated() : accountMenuItems()}
  </NavDropdown>
);

export default AccountMenu;
