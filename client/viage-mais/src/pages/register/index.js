import React from 'react';
import Button from '@/Components/Form/Button';
import Input from '@/Components/Form/Input';
import styles from './RegisterForm.module.css';

const register = () => {
    const [loading, setLoading] = React.useState();

    const handleSubmit = () => {};

    return (
        <div className={styles.cregister}>
            <h2 className={styles.subtitle}>Cadastre-se</h2>
            <form onSubmit={handleSubmit}>
                <Input label="Usuário" type="text" id="username" />
                <Input label="E-mail" type="email" id="email" />
                <Input label="Senha" type="password" id="password" />
                {loading ? (
                    <Button disabled>Cadastrando</Button>
                ) : (
                    <Button>Cadastrar</Button>
                )}
            </form>
        </div>
    );
};

export default register;
