import React, { useEffect, useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useParams } from "react-router-dom";
import { getData, postData } from "../../FetchApi";
import { addEvents } from "../../redux/eventSlice";
import EventForm from "./form/EventForm.jsx";
import GenericModal from "../modal/GenericModal.jsx";
import { closeModal, showModal } from "../../redux/genericModalSlice.js";
import Button from "react-bootstrap/Button";

export default function EventsContainer() {
  const user = useSelector((state) => state.auth.user);
  const events = useSelector((state) => state.event.events);
  const [enableDialogue, setEnableDialogue] = useState(false);
  const dispatch = useDispatch();
  const { groupId } = useParams();

  const handleSubmit = (values) => {
    // pass it from props
    let {eventStartTime, eventEndTime} = values;
    eventStartTime = new Date(eventStartTime).toISOString();
    eventEndTime = new Date(eventEndTime).toISOString();
    postData("/api/event/create", { ...values, groupId: groupId });
  };

  const fetchEvents = async () => {
    let params = { groupId: groupId };
    let data = await getData("/api/events", params);
    dispatch(addEvents({ events: data.events }));
    dispatch(closeModal());
  };

  useEffect(() => {
    fetchEvents();
  }, []);

  const onClickModal = (e) => {
    e.preventDefault();
    setEnableDialogue(true);
    dispatch(showModal());
  };

  return (
    <div className="container">
      <header className="blog-header lh-1 py-3">
        <div className="row flex-nowrap justify-content-between align-items-center">
          <div className="col-4 pt-1"></div>
          <div className="col-4 text-center"></div>
          <div className="col-4 d-flex justify-content-end align-items-center">
            <Button
              variant="secoundary"
              className="btn btn-sm btn-outline-secondary"
              onClick={(e) => onClickModal(e)}
              target={"eventModal"}
            >
              Create
            </Button>
            {enableDialogue ? (
              <GenericModal name="eventModal" title="Create Event">
                <EventForm onSubmit={(values) => handleSubmit(values)} />
              </GenericModal>
            ) : null}
          </div>
        </div>
      </header>

      <main className="container">
        <div className="row mb-2">
          {/*
                    Event name
                    descriptions
                    */}
          {events?.map((event) => {
            return (
              <div key={event.name} className="col-md-6">
                <div className="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                  <div className="col p-4 d-flex flex-column position-static">
                    <strong className="d-inline-block mb-2 text-primary">
                      {event.name}
                    </strong>
                    <div className="mb-1 text-muted">Nov 12</div>
                    <p className="card-text mb-auto">{event.description}</p>
                    {/*
                                    show more GroupComponent with more group details
                                    */}
                  </div>
                  <div className="col-auto d-none d-lg-block">
                    <svg
                      className="bd-placeholder-img"
                      width="200"
                      height="250"
                      xmlns="http://www.w3.org/2000/svg"
                      role="img"
                      aria-label="Placeholder: Thumbnail"
                      preserveAspectRatio="xMidYMid slice"
                      focusable="false"
                    >
                      <title>Placeholder</title>
                      <rect width="100%" height="100%" fill="#55595c"></rect>
                      <text x="50%" y="50%" fill="#eceeef" dy=".3em">
                        Thumbnail
                      </text>
                    </svg>
                  </div>
                </div>
              </div>
            );
          })}
        </div>
      </main>
    </div>
  );
}
