import ProtectedRouter from '@/Components/Helper/ProtectedRoute';
import Navigation from '@/Components/Navigation';
import Link from 'next/link';
import React from 'react';

export async function getStaticProps() {
    const response = await fetch('http://localhost:8080/api/hotel');
    const data = await response.json();

    return {
        props: { data },
    };
}

const destination = ({ data }) => {
    const handleDelete = async (id) => {
        const response = await fetch(`http://localhost:8080/api/hotel/${id}`, {
            method: 'DELETE',
            headers: {
                Authorization: 'Bearer ' + window.localStorage.getItem('token'),
            },
        });

        console.log('Valor de algo:', response); // Substitua 'algo' pela variável relevante

        if (!response.ok) {
            return null;
        }
    };

    return (
        <ProtectedRouter>
            <div className="container mt-4">
                <Navigation />
                <div className="header-client d-flex justify-content-between p-4">
                    <h4 className="text-white fw-bold">
                        Gerenciamento de hotel / hospedagem
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
                            <i className="fa-solid fa-circle-plus" /> Adicionar
                            novo
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
                                <th>CNPJ</th>
                                <th>Nome</th>
                                <th>Estrelas</th>
                                <th>Valor</th>
                                <th>Data Entrada</th>
                                <th>Data saída</th>
                                <th>Endereco</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {data &&
                                data.map((item) => (
                                    <tr key={item.id}>
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

                                        <td>{item.cnpj}</td>
                                        <td>{item.name}</td>
                                        <td>{item.stars}</td>
                                        <td>{item.value}</td>
                                        <td>{item.entryDate}</td>
                                        <td>{item.departureDate}</td>
                                        <td>{item.adress}</td>
                                        <td>
                                            <a>
                                                <i className="fa-solid fa-pen"></i>
                                            </a>
                                            <a
                                                onClick={() =>
                                                    handleDelete(item.id)
                                                }>
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
        </ProtectedRouter>
    );
};

export default destination;
