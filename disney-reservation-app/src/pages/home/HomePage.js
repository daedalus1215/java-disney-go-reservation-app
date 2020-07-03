import React from 'react';
import ReservationEventListView from './listview/ReservationEventListView';
import AddReservationForm from './form/AddReservationForm';
import styles from './HomePage.module.css';

const HomePage = () => {
    return <div>
        HomePage!
        <div className={styles.page}>
            <ReservationEventListView />
            <AddReservationForm />
        </div>
    </div>
};

export default HomePage;