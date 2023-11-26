import React, { useEffect } from 'react';
import { Button, Col, Row } from 'reactstrap';
import { ValidatedField, ValidatedForm, isEmail } from 'react-jhipster';
import { toast } from 'react-toastify';

import { useAppDispatch, useAppSelector } from 'app/config/store';
import { getSession } from 'app/shared/reducers/authentication';
import { saveAccountSettings, reset } from './settings.reducer';

export const SettingsPage = () => {
  const dispatch = useAppDispatch();
  const account = useAppSelector(state => state.authentication.account);
  const successMessage = useAppSelector(state => state.settings.successMessage);

  useEffect(() => {
    dispatch(getSession());
    return () => {
      dispatch(reset());
    };
  }, []);

  useEffect(() => {
    if (successMessage) {
      toast.success(successMessage);
    }
  }, [successMessage]);

  const handleValidSubmit = values => {
    dispatch(
      saveAccountSettings({
        ...account,
        ...values,
      })
    );
  };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="settings-title">
            [<strong>{account.login}</strong>] 사용자 설정
          </h2>
          <ValidatedForm id="settings-form" onSubmit={handleValidSubmit} defaultValues={account}>
            <ValidatedField
              name="firstName"
              label="이름"
              id="firstName"
              placeholder="이름"
              validate={{
                required: { value: true, message: '이름을 입력해 주세요.' },
                minLength: { value: 1, message: '이름은 최소 1자 이상이어야 합니다' },
                maxLength: { value: 50, message: '이름은 최대 50자 까지입니다' },
              }}
              data-cy="firstname"
            />
            <ValidatedField
              name="lastName"
              label="성"
              id="lastName"
              placeholder="성"
              validate={{
                required: { value: true, message: '성을 입력해 주세요.' },
                minLength: { value: 1, message: '성은 최소 1자 이상이어야 합니다' },
                maxLength: { value: 50, message: '성은 최대 50자 까지입니다' },
              }}
              data-cy="lastname"
            />
            <ValidatedField
              name="email"
              label="이메일"
              placeholder="이메일을 입력하세요"
              type="email"
              validate={{
                required: { value: true, message: '이메일 입력이 필요합니다.' },
                minLength: { value: 5, message: '이메일은 최소 5자 이상이어야 합니다' },
                maxLength: { value: 254, message: '이메일은 최대 50자 까지입니다.' },
                validate: v => isEmail(v) || '잘못된 이메일입니다.',
              }}
              data-cy="email"
            />
            <Button color="primary" type="submit" data-cy="submit">
              저장
            </Button>
          </ValidatedForm>
        </Col>
      </Row>
    </div>
  );
};

export default SettingsPage;
