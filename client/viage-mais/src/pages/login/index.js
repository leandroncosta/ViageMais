import React from 'react';
import { userContext } from '@/store/userContext';
import Input from '@/Components/Form/Input';
import styles from './LoginForm.module.css';
import Button from '@/Components/Form/Button';
import Link from 'next/link';
import { useRouter } from 'next/router';

const login = () => {
    const data = React.useContext(userContext);
    const [loading, setLoading] = React.useState(false);
    const router = useRouter();

    const handleSubmit = async (e) => {
        e.preventDefault();

        data.userLogin(e.target.user.value, e.target.password.value);
        router.push('/');
    };

    return (
        <div className={styles.clogin}>
            <h1 className={`${styles.title} mt-4`}>Login</h1>
            <form
                className={`${styles.form} animeLeft`}
                onSubmit={handleSubmit}>
                <Input label="Usuário" type="text" id="user" name="user" />
                <Input
                    label="Senha"
                    type="password"
                    id="password"
                    name="password"
                />
                {loading ? (
                    <Button disabled>Entrar</Button>
                ) : (
                    <Button>Entrar</Button>
                )}

                <Link className={styles.perdeu} href="/login/perdeu">
                    Esqueceu a senha?
                </Link>
                <div className={styles.cadastro}>
                    <p>Ainda não possui conta?</p>
                    <Link className={styles.cadastro} href="/register">
                        Cadastre-se
                    </Link>
                </div>
            </form>
        </div>
    );
};

export default login;
