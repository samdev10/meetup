import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import GroupForm from '../group/form/GroupForm.jsx';
import {postData} from '../../FetchApi.js'
import { useSelector, useDispatch } from 'react-redux'

export default function GenericModal(props) {
  const [show, setShow] = useState(false);
  const userId = useSelector((state) => state.auth.user.id);
  const state = useSelector((state) => state);

  const handleClose = () => {
    setShow(false);
  }
  const handleShow = (e) => {
    e.preventDefault();
    setShow(true);
  };

  return (
    <>
      <Button variant='secoundary' className='btn btn-sm btn-outline-secondary' onClick={handleShow} target={props.name}>
        Create
      </Button>

      <Modal id={props.name} show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Create</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          {props.children}
        </Modal.Body>
      </Modal>
    </>
  );
}
