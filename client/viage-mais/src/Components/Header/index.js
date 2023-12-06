import Link from 'next/link';
import { useRouter } from 'next/router';

const Header = () => {
    const router = useRouter();

    console.log(router);

    return (
        <header className="w-100">
            <nav className="container navbar navbar-expand-lg">
                <div className="container-fluid">
                    <div className="wrapper-logo">
                        <img
                            src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/airplane.svg"
                            alt="logo"
                            className="logo"
                        />
                        <Link
                            className={`navbar-brand text-white ${
                                router.asPath === '/' ? 'active' : ''
                            }`}
                            href="/">
                            ViageMais
                        </Link>
                    </div>
                    <button
                        className="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon" />
                    </button>
                    <div
                        className="collapse navbar-collapse"
                        id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <Link
                                    className={`nav-link text-white ${
                                        router.asPath === '/#hotels'
                                            ? 'l-active'
                                            : ''
                                    }`}
                                    href="/#hotels">
                                    Hotéis
                                </Link>
                                <span />
                            </li>
                            <li className="nav-item">
                                <Link
                                    className={`nav-link text-white ${
                                        router.asPath === '/#destinations'
                                            ? 'l-active'
                                            : ''
                                    }`}
                                    href="/#destinations">
                                    Destinos
                                </Link>
                                <span />
                            </li>
                            <li className="nav-item">
                                <Link
                                    className={`${
                                        router.asPath === '/#promotions'
                                            ? 'active'
                                            : ''
                                    } nav-link text-white`}
                                    href="#promotions">
                                    Promoções
                                </Link>
                                <span />
                            </li>
                            <li className="nav-item">
                                <Link
                                    className={`${
                                        router.asPath === '/#about'
                                            ? 'active'
                                            : ''
                                    } nav-link text-white`}
                                    href="/#about">
                                    Contato
                                </Link>
                                <span />
                            </li>
                            <li className="nav-item">
                                <Link
                                    className={`nav-link text-white ${
                                        router.pathname === '/login'
                                            ? 'l-active'
                                            : ''
                                    }`}
                                    href="/login">
                                    Login
                                </Link>
                                <span />
                            </li>
                        </ul>
                        <form className="d-flex" role="search">
                            <input
                                className="form-control me-2"
                                type="search"
                                placeholder="Viagens , hóteis..."
                                aria-label="Search"
                            />
                            <button className="btn" type="submit">
                                Busque
                            </button>
                        </form>
                    </div>
                </div>
            </nav>
            <div className="home">
                <h2>Mais de 60 anos de Experiência</h2>
                <h2></h2>
                <h6>Viagens e Turismo</h6>
            </div>
        </header>
    );
};

export default Header;
