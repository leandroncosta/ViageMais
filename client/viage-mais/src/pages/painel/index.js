import ProtectedRouter from '@/Components/Helper/ProtectedRoute';
import Navigation from '@/Components/Navigation';
import { statesData } from '@/constants/states';
import Link from 'next/link';
import { useRouter } from 'next/router';

export async function getStaticProps() {
    const response = await fetch('http://localhost:8080/api/destination');
    const data = await response.json();

    return {
        props: { data },
    };
}

const Painel = ({ data }) => {
    const router = useRouter();

    const handleDelete = async (id) => {
        const response = await fetch(
            `http://localhost:8080/api/destination/${id}`,
            {
                method: 'DELETE',
                headers: {
                    Authorization:
                        'Bearer ' + window.localStorage.getItem('token'),
                },
            }
        );

        if (!response.ok) {
            return null;
        }
        router.push(router.route);
    };

    const handlePut = async (id) => {
        e.preventDefault();

        const response = await fetch(
            `http://localhost:8080/api/destination/${id}`,
            {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    Authorization:
                        'Bearer ' + window.localStorage.getItem('token'),
                },
                body: JSON.stringify({
                    city: e.target.city.value,
                    state: e.target.state.value,
                }),
            }
        );

        if (!response.ok) {
            return;
        }

        router.push(router.route);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        const response = await fetch(`http://localhost:8080/api/destination`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                Authorization: 'Bearer ' + window.localStorage.getItem('token'),
            },
            body: JSON.stringify({
                city: e.target.city.value,
                state: e.target.state.value,
                imageUrl: 'a',
            }),
        });

        if (!response.ok) {
            return;
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
                            data-bs-target="#modalAdd">
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
                                <th>Cidade</th>
                                <th>Estado</th>
                                <th>Imagem</th>
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
                                        <td>{item.city}</td>
                                        <td>{item.state}</td>
                                        <td></td>
                                        <td>
                                            <a
                                                data-bs-toggle="modal"
                                                data-bs-target="#modalEdit">
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

                {/* modal */}
                <div
                    className="modal fade "
                    id="modalAdd"
                    tabIndex="-1"
                    aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h1
                                    className="modal-title fs-5"
                                    id="exampleModalLabel">
                                    Adicionar destino
                                </h1>
                            </div>
                            <div className="modal-body">
                                <form onSubmit={handleSubmit}>
                                    <div className="mb-3">
                                        <label
                                            htmlFor="InputDescricao"
                                            className="form-label">
                                            Cidade
                                        </label>
                                        <input
                                            type="text"
                                            className="form-control"
                                            id="city"
                                            name="city"
                                        />
                                    </div>
                                    <div className="mb-3">
                                        <label
                                            htmlFor="InputDescricao"
                                            className="form-label">
                                            Estado
                                        </label>
                                        <select name="state" id="">
                                            {statesData &&
                                                statesData.states.map(
                                                    (state, index) => (
                                                        <option
                                                            className="p-2"
                                                            key={index}>
                                                            {
                                                                Object.keys(
                                                                    state
                                                                )[0]
                                                            }
                                                        </option>
                                                    )
                                                )}
                                        </select>
                                    </div>

                                    <button
                                        type="submit"
                                        className="btn btn-primary">
                                        Salvar
                                    </button>
                                </form>
                            </div>
                            <div className="modal-footer">
                                <button
                                    type="button"
                                    className="btn btn-secondary"
                                    data-bs-dismiss="modal">
                                    Close
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <div
                    className="modal fade "
                    id="modalEdit"
                    tabIndex="-1"
                    aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h1
                                    className="modal-title fs-5"
                                    id="exampleModalLabel">
                                    Adicionar destino
                                </h1>
                            </div>
                            <div className="modal-body">
                                <form onSubmit={handlePut}>
                                    <div className="mb-3">
                                        <label
                                            htmlFor="InputDescricao"
                                            className="form-label">
                                            Cidade
                                        </label>
                                        <input
                                            type="text"
                                            className="form-control"
                                            id="InputData"
                                        />
                                    </div>
                                    <div className="mb-3">
                                        <label
                                            htmlFor="InputDescricao"
                                            className="form-label">
                                            Estado
                                        </label>
                                        <select name="" id="">
                                            {statesData &&
                                                statesData.states.map(
                                                    (state, index) => (
                                                        <option key={index}>
                                                            {
                                                                Object.keys(
                                                                    state
                                                                )[0]
                                                            }
                                                        </option>
                                                    )
                                                )}
                                        </select>
                                    </div>

                                    <button
                                        type="submit"
                                        className="btn btn-primary">
                                        Salvar
                                    </button>
                                </form>
                            </div>
                            <div className="modal-footer">
                                <button
                                    type="button"
                                    className="btn btn-secondary"
                                    data-bs-dismiss="modal">
                                    Close
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </ProtectedRouter>
    );
};

export default Painel;
