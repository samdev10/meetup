import React, { useState } from "react";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import { closeModal, showModal } from "../../redux/genericModalSlice.js";
import { useSelector, useDispatch } from "react-redux";

export default function GenericModal(props) {
  const userId = useSelector((state) => state.auth.user.id);
  const show = useSelector((state) => state.genericModal.showModal);
  const state = useSelector((state) => state);
  const dispatch = useDispatch();

  const onClickModal = (e) => {
    e.preventDefault();
    dispatch(showModal());
  };

  const onHideModal = () => {
    dispatch(closeModal());
  }

  return (
    <>
      <Button
        variant="secoundary"
        className="btn btn-sm btn-outline-secondary"
        onClick={(e) => onClickModal(e)}
        target={props.name}
      >
        Create
      </Button>

      <Modal id={props.name} show={show} onHide={onHideModal}>
        <Modal.Header closeButton>
          <Modal.Title>{props.title}</Modal.Title>
        </Modal.Header>
        <Modal.Body>{props.children}</Modal.Body>
      </Modal>
    </>
  );
}


