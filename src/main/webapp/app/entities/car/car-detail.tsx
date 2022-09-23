import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './car.reducer';

export const CarDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const carEntity = useAppSelector(state => state.car.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="carDetailsHeading">
          <Translate contentKey="myappApp.car.detail.title">Car</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{carEntity.id}</dd>
          <dt>
            <span id="manufacturer">
              <Translate contentKey="myappApp.car.manufacturer">Manufacturer</Translate>
            </span>
          </dt>
          <dd>{carEntity.manufacturer}</dd>
          <dt>
            <span id="model">
              <Translate contentKey="myappApp.car.model">Model</Translate>
            </span>
          </dt>
          <dd>{carEntity.model}</dd>
          <dt>
            <span id="licensePlate">
              <Translate contentKey="myappApp.car.licensePlate">License Plate</Translate>
            </span>
          </dt>
          <dd>{carEntity.licensePlate}</dd>
          <dt>
            <span id="seatCount">
              <Translate contentKey="myappApp.car.seatCount">Seat Count</Translate>
            </span>
          </dt>
          <dd>{carEntity.seatCount}</dd>
          <dt>
            <span id="convertible">
              <Translate contentKey="myappApp.car.convertible">Convertible</Translate>
            </span>
          </dt>
          <dd>{carEntity.convertible ? 'true' : 'false'}</dd>
          <dt>
            <span id="rating">
              <Translate contentKey="myappApp.car.rating">Rating</Translate>
            </span>
          </dt>
          <dd>{carEntity.rating}</dd>
          <dt>
            <span id="engineType">
              <Translate contentKey="myappApp.car.engineType">Engine Type</Translate>
            </span>
          </dt>
          <dd>{carEntity.engineType}</dd>
          <dt>
            <span id="avaiable">
              <Translate contentKey="myappApp.car.avaiable">Avaiable</Translate>
            </span>
          </dt>
          <dd>{carEntity.avaiable ? 'true' : 'false'}</dd>
        </dl>
        <Button tag={Link} to="/car" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/car/${carEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default CarDetail;
