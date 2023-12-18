import React from 'react';
import styles from './Navigation.module.css';
import Link from 'next/link';
import { useRouter } from 'next/router';

const Navigation = () => {
    const router = useRouter();

    console.log(router.route);
    console.log(router.route == '/painel');

    return (
        <>
            <ul className={styles.pnavigation}>
                <li className={router.route == '/painel' ? 'pactive' : ''}>
                    <Link href={'/painel'}>Destinos</Link>
                </li>
                <li
                    className={
                        router.route == '/painel/hotel' ? 'pactive' : ''
                    }>
                    <Link href={'/painel/hotel'}>Hoteis</Link>
                </li>
                <li
                    className={
                        router.route == '/painel/ticket' ? 'pactive' : ''
                    }>
                    <Link href={'/painel/ticket'}>Ticket</Link>
                </li>
            </ul>
        </>
    );
};

export default Navigation;
