import React from 'react';
import Button from '@/Components/Form/Button';
import Input from '@/Components/Form/Input';
import styles from './RegisterForm.module.css';
import { useRouter } from 'next/router';

const register = () => {
    const router = useRouter();

    const handleSubmit = async (e) => {
        e.preventDefault();

        const response = await fetch(`http://localhost:8080/auth/register`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                login: e.target.username.value,
                password: e.target.password.value,
                role: 'ADMIN',
            }),
        });

        if (!response.ok) {
            return null;
        }

        router.push('/login');
    };

    return (
        <div className={styles.cregister}>
            <h2 className={styles.subtitle}>Cadastre-se</h2>
            <form onSubmit={handleSubmit}>
                <Input label="Usuário" type="text" id="username" />
                <Input label="E-mail" type="email" id="email" />
                <Input label="Senha" type="password" id="password" />

                <Button>Cadastrar</Button>
            </form>
        </div>
    );
};

export default register;
