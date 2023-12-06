const Header = () => {
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
                        <a className="navbar-brand text-white" href="/">
                            ViageMais
                        </a>
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
                                <a
                                    className="nav-link text-white"
                                    href="/#hotels">
                                    Hotéis
                                </a>
                                <span />
                            </li>
                            <li className="nav-item">
                                <a
                                    className="nav-link text-white"
                                    href="/#destinations">
                                    Destinos
                                </a>
                                <span />
                            </li>
                            <li className="nav-item">
                                <a
                                    className="nav-link text-white"
                                    href="#promotions">
                                    Promoções
                                </a>
                                <span />
                            </li>
                            <li className="nav-item">
                                <a
                                    className="nav-link text-white"
                                    href="/#about">
                                    Contato
                                </a>
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

                        <div className="nav-item">
                            <a className="nav-link text-white" href="/login">
                                Login
                            </a>
                            <span />
                        </div>
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
