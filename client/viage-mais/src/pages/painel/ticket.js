import ProtectedRouter from '@/Components/Helper/ProtectedRoute';
import Navigation from '@/Components/Navigation';
import { useRouter } from 'next/router';
import React from 'react';

export async function getStaticProps() {
    const response = await fetch('http://localhost:8080/api/ticket');
    const data = await response.json();

    return {
        props: { data },
    };
}

const ticket = ({ data }) => {
    const router = useRouter();

    const handleDelete = async (id) => {
        const response = await fetch(`http://localhost:8080/api/ticket/${id}`, {
            method: 'DELETE',
            headers: {
                Authorization: 'Bearer ' + window.localStorage.getItem('token'),
            },
        });

        console.log('Valor de algo:', response); // Substitua 'algo' pela variável relevante

        if (!response.ok) {
            return null;
        }

        router.push(router.route);
    };

    return (
        <ProtectedRouter>
            <div className="container mt-4">
                <Navigation />
                <div className="header-client d-flex justify-content-between p-4">
                    <h4 className="text-white fw-bold">
                        Gerenciamento de destinos
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
                                <th>Taxa de serviço</th>
                                <th>Taxa de embarque</th>
                                <th>Compania</th>
                                <th>Ida e volta</th>
                                <th>Quantidade</th>
                                <th>value</th>
                                <th>Destino</th>
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

                                        <td>{item.serviceFee}</td>
                                        <td>{item.boardingFee}</td>
                                        <td>{item.airline}</td>
                                        <td>{item.roundTrip}</td>
                                        <td>{item.quantity}</td>
                                        <td>{item.value}</td>
                                        <td>
                                            {item.destination &&
                                                `${item.destination.city} | ${item.destination.state}`}
                                        </td>
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

export default ticket;
