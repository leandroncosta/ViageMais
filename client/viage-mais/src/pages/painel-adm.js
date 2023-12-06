export async function getStaticProps() {
    const response = await fetch('https://jsonplaceholder.typicode.com/todos');
    const data = await response.json();

    return {
        props: { data },
    };
}

const adm = ({ data }) => {
    return (
        <div className="container mt-4">
            <div className="header-client d-flex justify-content-between p-4">
                <h4 className="text-white fw-bold">
                    Gerenciamento de clientes
                </h4>
                <div>
                    <a
                        className="btn btn-danger disabled fw-bold"
                        id="btn-deletes"
                        disabled="">
                        <i className="fa-solid fa-circle-minus" /> Deletar
                    </a>
                    <a
                        className="btn btn-success fw-bold"
                        data-bs-toggle="modal"
                        data-bs-target="#modalNovoCliente">
                        <i className="fa-solid fa-circle-plus" /> Adicionar novo
                    </a>
                </div>
            </div>
            <div className="table-responsive">
                <table className="table">
                    <thead className="table-light">
                        <tr>
                            <th>
                                <div>
                                    <input
                                        className="form-check-input check-main"
                                        type="checkbox"
                                        id="checkboxNoLabel"
                                        defaultValue=""
                                        aria-label="..."
                                    />
                                </div>
                            </th>
                            <th>Nome</th>
                            <th>E-mail</th>
                            <th>Endereco</th>
                            <th>Phone</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {data &&
                            data.map((item) => (
                                <tr key={item.title}>
                                    <td>
                                        <div>
                                            <input
                                                className="form-check-input "
                                                type="checkbox"
                                                id="checkboxNoLabel"
                                                name="client"
                                                aria-label="..."
                                            />
                                        </div>
                                    </td>
                                    <td>{item.title}</td>
                                    <td>aaa</td>
                                    <td>aaa</td>
                                    <td>12132</td>
                                    <td>
                                        <a>
                                            <i className="fa-solid fa-pen"></i>
                                        </a>
                                        <a
                                            data-bs-toggle="modal"
                                            data-bs-target="#deleteModal">
                                            <i className="fas fa-trash trash"></i>
                                        </a>
                                    </td>
                                </tr>
                            ))}
                    </tbody>
                </table>
            </div>
            <div className="container-pagination d-flex justify-content-between">
                <h6> 5 de 25</h6>
                <nav aria-label="...">
                    <ul className="pagination">
                        <li className="page-item disabled">
                            <span className="page-link">Previous</span>
                        </li>
                        <li className="page-item">
                            <a className="page-link" href="#">
                                1
                            </a>
                        </li>
                        <li className="page-item active">
                            <span className="page-link">
                                2
                                <span className="sr-only" />
                            </span>
                        </li>
                        <li className="page-item">
                            <a className="page-link" href="#">
                                3
                            </a>
                        </li>
                        <li className="page-item">
                            <a className="page-link" href="#">
                                Next
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    );
};

export default adm;
