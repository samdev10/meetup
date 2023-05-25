import React, { useEffect } from "react";
import { useSelector, useDispatch } from 'react-redux'
import GenericModal from "../modal/GenericModal.jsx";
import 'bootstrap/dist/js/bootstrap.js';
import 'bootstrap/dist/css/bootstrap.css';
import { getData } from "../../FetchApi.js";
import { addGroups } from "../../redux/groupSlice.js";
import { Link } from "react-router-dom";
import GroupForm from "./form/GroupForm.jsx";
import { postData } from "../../FetchApi.js";
import { closeModal, showModal } from "../../redux/genericModalSlice.js";

function GroupContainer() {
    const state = useSelector((state) => state);
    const user = useSelector((state) => state.auth.user);
    const groups = useSelector((state) => state.group.groups);
    const userId = useSelector((state) => state.auth.user.id);
    const dispatch = useDispatch();

    const fetchGroups = async () => {
        let params = { userId: user.id };
        let data = await getData('/api/group/userGroups', params);
        console.log('group data', data);
        dispatch(addGroups({ groups: data.groups }));
    };

    useEffect(() => {
        fetchGroups();
    },[]);

    const handleSubmit = (values) => {
        // pass it from props
        postData("/api/group/create", { ...values, userId: userId });
        dispatch(closeModal());
      };

    return (
        <div className="container">
            <header className="blog-header lh-1 py-3">
                <div className="row flex-nowrap justify-content-between align-items-center">
                <div className="col-4 pt-1">
                </div>
                <div className="col-4 text-center">
                </div>
                <div className="col-4 d-flex justify-content-end align-items-center">
                    <GenericModal name="groupModal" title="Create Group">
                        <GroupForm onSubmit={(values) => handleSubmit(values)}/>
                    </GenericModal>
                </div>
                </div>
            </header>

            <main className="container">
                <div className="row mb-2">
                    {/*
                    Group catogery
                    Group name
                    Since/last posted date
                    descriptions
                    continue reading
                    */}
                    {
                        groups?.map(g => {
                            return (
                                <div key={g.name} className="col-md-6">
                                <div className="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                                <div className="col p-4 d-flex flex-column position-static">
                                    <strong className="d-inline-block mb-2 text-primary">{g.name}</strong>
                                    <div className="mb-1 text-muted">Nov 12</div>
                                    <p className="card-text mb-auto">{g.description}</p>
                                    {/*
                                    show more GroupComponent with more group details
                                    */}
                                    <Link className="stretched-link" to={"/events/" + g.id} params={{groupId: g.id}}>Continue reading</Link>
                                </div>
                                <div className="col-auto d-none d-lg-block">
                                    <svg className="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
                                </div>
                            </div>
                            </div>
                            )
                        })
                    }
                </div>
            </main>
        </div>
    );
}

export default GroupContainer;